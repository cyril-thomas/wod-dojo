package edu.simplyct.boxbasics.helper;

import edu.simplyct.boxbasics.helper.dto.AboutPage;
import edu.simplyct.boxbasics.helper.dto.CoachDetail;
import edu.simplyct.boxbasics.helper.dto.GymDetail;
import edu.simplyct.boxbasics.helper.dto.HomePage;
import edu.simplyct.boxbasics.model.About;
import edu.simplyct.boxbasics.model.Coach;
import edu.simplyct.boxbasics.model.Home;
import edu.simplyct.boxbasics.model.Organization;
import edu.simplyct.boxbasics.repository.AboutRepository;
import edu.simplyct.boxbasics.repository.CoachRepository;
import edu.simplyct.boxbasics.repository.HomeRepository;
import edu.simplyct.boxbasics.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by cyril on 6/30/15.
 */
@Service
public class PortalHelper {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    HomeRepository homeRepository;

    @Autowired
    AboutRepository aboutRepository;

    @Autowired
    CoachRepository coachRepository;

    public HomePage getHomePage(Long orgId) {
        Home home = homeRepository.findByOrganizationId(orgId);
        return new HomePage(home);
    }

    public GymDetail getGymDetail(Long orgId) {
        Organization organization = organizationRepository.findOne(orgId);
        return new GymDetail(organization);
    }

    public AboutPage getAboutPage(Long orgId) {
        About about = aboutRepository.findByOrganizationId(orgId);
        return new AboutPage(about);
    }

    public List<CoachDetail> getCoaches(Long orgId) {
        List<Coach> coaches = coachRepository.findByUserOrganizationId(orgId);
        return coaches.stream()
                      .map(e -> new CoachDetail(e))
                      .collect(Collectors.toList());
    }
}

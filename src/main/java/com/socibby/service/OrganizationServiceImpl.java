package com.socibby.service;

import com.socibby.model.Organization;
import com.socibby.model.User;
import com.socibby.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationServiceImpl(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public void insertOrganization(Organization organization) {
        organizationRepository.insertOrganization(organization);
    }

    public void updateOrganization(Organization organization) {
        organizationRepository.updateOrganization(organization);
    }

    public Organization getOrganizationById(Long id) {
        return organizationRepository.getOrganizationById(id);
    }

    public Organization getOrganization(String username) {
        return organizationRepository.getOrganization(username);
    }

    public Organization validateOrganization(String username, String password) {
        return organizationRepository.validateOrganization(username, password);
    }

    public List<Organization> getOrganizationByUser(User user) {
        return organizationRepository.getOrganizationByUser(user);
    }

    public List<Organization> getOrganizationByOrganization(Organization organization) {
        return organizationRepository.getOrganizationByOrganization(organization);
    }

    public List<Organization> getOrganizationByCategoryName(String categoryName) {
        return organizationRepository.getOrganizationByCategoryName(categoryName);
    }

}

package com.socibby.repository;

import com.socibby.model.Organization;
import com.socibby.model.User;

import java.util.List;

public interface OrganizationRepository {

    void insertOrganization(Organization organization);

    void updateOrganization(Organization organization);

    Organization getOrganizationById(Long id);

    Organization getOrganization(String username);

    Organization validateOrganization(String username, String password);

    List<Organization> getOrganizationByUser(User user);

    List<Organization> getOrganizationByOrganization(Organization organization);

    List<Organization> getOrganizationByCategoryName(String categoryName);

}

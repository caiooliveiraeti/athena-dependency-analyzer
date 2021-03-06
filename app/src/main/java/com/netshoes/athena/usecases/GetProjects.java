package com.netshoes.athena.usecases;

import com.netshoes.athena.domains.PaginatedResponse;
import com.netshoes.athena.domains.Project;
import com.netshoes.athena.domains.RequestOfPage;
import com.netshoes.athena.gateways.ProjectGateway;
import com.netshoes.athena.usecases.exceptions.ProjectNotFoundException;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GetProjects {

  private final ProjectGateway projectGateway;

  public PaginatedResponse<Project> all(RequestOfPage requestOfPage) {
    return projectGateway.findAll(requestOfPage);
  }

  public PaginatedResponse<Project> search(RequestOfPage requestOfPage, String name) {
    return projectGateway.findByNameContaining(requestOfPage, name);
  }

  public Project byId(String id) throws ProjectNotFoundException {
    final Optional<Project> opProject = projectGateway.findById(id);
    if (!opProject.isPresent()) {
      throw new ProjectNotFoundException(id);
    }
    return opProject.get();
  }
}

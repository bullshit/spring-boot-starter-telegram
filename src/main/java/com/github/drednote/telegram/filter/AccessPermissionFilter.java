package com.github.drednote.telegram.filter;

import com.github.drednote.telegram.core.request.ExtendedBotRequest;
import com.github.drednote.telegram.datasource.Permission;
import com.github.drednote.telegram.filter.PermissionProperties.Access;
import com.github.drednote.telegram.filter.PermissionProperties.Role;
import com.github.drednote.telegram.updatehandler.response.ForbiddenHandlerResponse;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.lang.NonNull;

@RequiredArgsConstructor
public non-sealed class AccessPermissionFilter implements PriorityUpdateFilter {

  private final PermissionProperties permissionProperties;

  @Override
  public void preFilter(@NonNull ExtendedBotRequest request) {
    if (permissionProperties.getAccess() == Access.BY_ROLE) {
      Permission permission = request.getPermission();
      boolean canRead = permission.getRoles().stream()
          .anyMatch(role -> Optional.ofNullable(permissionProperties.getRoles().get(role))
              .map(Role::isCanRead)
              .orElse(false));
      if (!canRead) {
        request.setResponse(ForbiddenHandlerResponse.INSTANCE);
      }
    }
  }

  @Override
  public int getPreOrder() {
    return Ordered.HIGHEST_PRECEDENCE + 101;
  }
}
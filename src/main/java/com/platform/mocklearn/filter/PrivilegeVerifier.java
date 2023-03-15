package com.platform.mocklearn.filter;

import com.platform.mocklearn.enums.SpaceEnum;
import com.platform.mocklearn.enums.UserRole;
import com.platform.mocklearn.handler.SecurityContextHolder;

public class PrivilegeVerifier {
    public static boolean hasPermission(SpaceEnum spaceEnum) {
        return !(spaceEnum != SpaceEnum.PUBLIC && SecurityContextHolder.getUserRole() != UserRole.ADMIN);
    }
}

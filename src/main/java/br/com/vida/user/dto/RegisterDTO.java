package br.com.vida.user.dto;

import br.com.vida.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}

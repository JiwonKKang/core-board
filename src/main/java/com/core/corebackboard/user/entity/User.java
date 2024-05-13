package com.core.corebackboard.user.entity;

import com.core.corebackboard.user.service.UserDomain;
import com.core.corebackboard.user.service.UserInfo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    public UserDomain toDomain() {
        return new UserDomain(
                id,
                new UserInfo(
                        email,
                        password,
                        name
                )
        );
    }
}

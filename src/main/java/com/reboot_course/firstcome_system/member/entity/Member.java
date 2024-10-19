package com.reboot_course.firstcome_system.member.entity;

import com.reboot_course.firstcome_system.auth.encrypt.AESConverter;
import com.reboot_course.firstcome_system.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Getter
@SuperBuilder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer id;

    @Convert(converter = AESConverter.class)
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Convert(converter = AESConverter.class)
    @Column(nullable = false, unique = true)
    private String email;

    @Convert(converter = AESConverter.class)
    @Column(nullable = false)
    private String phone;

    @Convert(converter = AESConverter.class)
    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private LocalDateTime lastPasswordUpdated;
}
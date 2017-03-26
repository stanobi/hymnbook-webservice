package com.hymnbook.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.hymnbook.model.UserInformation;

@Transactional
public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {

}

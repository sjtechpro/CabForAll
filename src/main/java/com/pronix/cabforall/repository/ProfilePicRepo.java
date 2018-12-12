package com.pronix.cabforall.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pronix.cabforall.model.ProfilePic;
@Repository
public interface ProfilePicRepo extends JpaRepository<ProfilePic, String> {

}

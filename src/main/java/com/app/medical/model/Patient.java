package com.app.medical.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn( name = "user_id" )
public class Patient extends User {

}


package com.yahoo.tillyqb.springboot.magic_card_deck_tracker.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    @Id
    private String userName;
    @Email
    private String email;
    //could put password here but not reccomened

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerName")
    private List<Deck> decks;
}

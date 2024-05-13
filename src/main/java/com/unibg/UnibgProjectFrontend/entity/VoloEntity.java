package com.unibg.UnibgProjectFrontend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table
@Entity(name = "volo")
@Getter
@Setter
public class VoloEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String partenza;
    @Column
    private String arrivo;
    @Column
    private String data;
    @Column
    private String compagnia;
    @Column
    private String h_partenza;
    @Column
    private String h_arrivo;
    @Column
    private String prezzo;
}

package com.example.project_exam;

import com.example.project_exam.entities.*;
import com.example.project_exam.enums.*;
import com.example.project_exam.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ProjectExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectExamApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(
            ClientRepository clientRepository,
            ContratAutomobileRepository contratAutomobileRepository,
            ContratHabitationRepository contratHabitationRepository,
            ContratSanteRepository contratSanteRepository,
            PaiementRepository paiementRepository,
            AppUserRepository appUserRepository,
            AppRoleRepository appRoleRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            AppRole roleClient = appRoleRepository.save(AppRole.builder().roleName("ROLE_CLIENT").build());
            AppRole roleEmploye = appRoleRepository.save(AppRole.builder().roleName("ROLE_EMPLOYE").build());
            AppRole roleAdmin = appRoleRepository.save(AppRole.builder().roleName("ROLE_ADMIN").build());

            appUserRepository.save(AppUser.builder()
                    .username("client1").password(passwordEncoder.encode("1234"))
                    .active(true).roles(List.of(roleClient)).build());
            appUserRepository.save(AppUser.builder()
                    .username("employe1").password(passwordEncoder.encode("1234"))
                    .active(true).roles(List.of(roleEmploye)).build());
            appUserRepository.save(AppUser.builder()
                    .username("admin").password(passwordEncoder.encode("1234"))
                    .active(true).roles(List.of(roleAdmin)).build());

            Client c1 = clientRepository.save(Client.builder().nom("Ahmed Alami").email("ahmed@email.com").build());
            Client c2 = clientRepository.save(Client.builder().nom("Sara Benali").email("sara@email.com").build());
            Client c3 = clientRepository.save(Client.builder().nom("Youssef Idrissi").email("youssef@email.com").build());

            ContratAutomobile ca = new ContratAutomobile();
            ca.setClient(c1);
            ca.setDateSouscription(new Date());
            ca.setStatut(StatutContrat.EN_COURS);
            ca.setMontantCotisation(1200.0);
            ca.setDureeContrat(12);
            ca.setTauxCouverture(80.0);
            ca.setNumImmatriculation("123456-A-7");
            ca.setMarque("Toyota");
            ca.setModele("Corolla");
            contratAutomobileRepository.save(ca);

            ContratHabitation ch = new ContratHabitation();
            ch.setClient(c2);
            ch.setDateSouscription(new Date());
            ch.setStatut(StatutContrat.VALIDE);
            ch.setDateValidation(new Date());
            ch.setMontantCotisation(800.0);
            ch.setDureeContrat(24);
            ch.setTauxCouverture(70.0);
            ch.setTypeLogement(TypeLogement.APPARTEMENT);
            ch.setAdresse("12 Rue Hassan II, Casablanca");
            ch.setSuperficie(95.5);
            contratHabitationRepository.save(ch);

            ContratSante cs = new ContratSante();
            cs.setClient(c3);
            cs.setDateSouscription(new Date());
            cs.setStatut(StatutContrat.EN_COURS);
            cs.setMontantCotisation(500.0);
            cs.setDureeContrat(6);
            cs.setTauxCouverture(90.0);
            cs.setNiveauCouverture(NiveauCouverture.PREMIUM);
            cs.setNombrePersonnesCouvertes(4);
            contratSanteRepository.save(cs);

            paiementRepository.save(Paiement.builder().date(new Date()).montant(100.0).type(TypePaiement.MENSUALITE).contrat(ca).build());
            paiementRepository.save(Paiement.builder().date(new Date()).montant(1200.0).type(TypePaiement.PAIEMENT_ANNUEL).contrat(ch).build());
            paiementRepository.save(Paiement.builder().date(new Date()).montant(250.0).type(TypePaiement.PAIEMENT_EXCEPTIONNEL).contrat(cs).build());

            System.out.println("Donnees de test inserees avec succes.");
        };
    }
}

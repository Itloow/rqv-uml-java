package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgentPolicierTest {

    @Test
    void authentification_reussit_si_motDePasse_correct() {
        AgentPolicier agent = new AgentPolicier("Dupont", "Alex", "A001", "secret");
        assertTrue(agent.sAuthentifier("secret"));
    }

    @Test
    void authentification_echoue_si_motDePasse_incorrect() {
        AgentPolicier agent = new AgentPolicier("Dupont", "Alex", "A001", "secret");
        assertFalse(agent.sAuthentifier("mauvais"));
    }

    @Test
    void authentification_echoue_si_motDePasse_null() {
        AgentPolicier agent = new AgentPolicier("Dupont", "Alex", "A001", "secret");
        assertFalse(agent.sAuthentifier(null));
    }
}

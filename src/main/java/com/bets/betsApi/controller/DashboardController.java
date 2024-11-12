package com.bets.betsApi.controller;

import com.bets.betsApi.beans.dto.BankrollEvolutionDTO;
import com.bets.betsApi.beans.dto.DashboardMetricsDTO;
import com.bets.betsApi.beans.dto.DistributionDTO;
import com.bets.betsApi.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:4200") // Ajuste conforme necessário
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/metrics")
    public DashboardMetricsDTO getDashboardMetrics() {
        return dashboardService.getDashboardMetrics();
    }

    @GetMapping("/evolution")
    public List<BankrollEvolutionDTO> getBankrollEvolution() {
        return dashboardService.getBankrollEvolution();
    }

    @GetMapping("/distribution/sport")
    public List<DistributionDTO> getBetDistributionBySport() {
        return dashboardService.getBetDistributionBySport();
    }

    @GetMapping("/distribution/tipster")
    public List<DistributionDTO> getBetDistributionByTipster() {
        return dashboardService.getBetDistributionByTipster();
    }

    @GetMapping("/distribution/category")
    public List<DistributionDTO> getBetDistributionByCategory() {
        return dashboardService.getBetDistributionByCategory();
    }

    // Outros endpoints para outras métricas se necessário
}

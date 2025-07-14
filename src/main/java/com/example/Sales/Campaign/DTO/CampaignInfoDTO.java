package com.example.Sales.Campaign.DTO;

import com.example.Sales.Campaign.model.SaleCampaign;

import java.util.List;

public class CampaignInfoDTO {

    List<SaleCampaign> pastCampaign;
    List<SaleCampaign> currentCampaign;
    List<SaleCampaign> futureCampaign;

    public CampaignInfoDTO() {
    }

    public CampaignInfoDTO(List<SaleCampaign> pastCampaign, List<SaleCampaign> currentCampaign, List<SaleCampaign> futureCampaign) {
        this.pastCampaign = pastCampaign;
        this.currentCampaign = currentCampaign;
        this.futureCampaign = futureCampaign;
    }

    public List<SaleCampaign> getPastCampaign() {
        return pastCampaign;
    }

    public void setPastCampaign(List<SaleCampaign> pastCampaign) {
        this.pastCampaign = pastCampaign;
    }

    public List<SaleCampaign> getCurrentCampaign() {
        return currentCampaign;
    }

    public void setCurrentCampaign(List<SaleCampaign> currentCampaign) {
        this.currentCampaign = currentCampaign;
    }

    public List<SaleCampaign>  getFutureCampaign() {
        return futureCampaign;
    }

    public void setFutureCampaign(List<SaleCampaign> futureCampaign) {
        this.futureCampaign = futureCampaign;
    }
}

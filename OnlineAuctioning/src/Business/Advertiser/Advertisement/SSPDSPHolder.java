/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.Advertisement;

import Business.Advertiser.DemandSidePlatform.DSP;
import Business.Publisher.ServerSidePlatform.SSP;

/**
 *
 * @author Sonam
 */
public class SSPDSPHolder {
    String buttonName;
    private SSP ssp;
    private DSP dsp;

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public SSP getSsp() {
        return ssp;
    }

    public void setSsp(SSP ssp) {
        this.ssp = ssp;
    }

    public DSP getDsp() {
        return dsp;
    }

    public void setDsp(DSP dsp) {
        this.dsp = dsp;
    }
    
}

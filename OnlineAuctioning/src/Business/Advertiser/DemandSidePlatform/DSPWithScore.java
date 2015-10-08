/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Advertiser.DemandSidePlatform;

/**
 *
 * @author Sonam
 */
public class DSPWithScore {
    private DSP dsp;
    private double dspScore; 

    public DSP getDsp() {
        return dsp;
    }

    public void setDsp(DSP dsp) {
        this.dsp = dsp;
    }

    public double getDspScore() {
        return dspScore;
    }

    public void setDspScore(double dspScore) {
        this.dspScore = dspScore;
    }
}

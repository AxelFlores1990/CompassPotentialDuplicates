package org.compass.model;

public class Match {

    public enum ACCURACY{
        VERY_LOW, LOW, HIGH, VERY_HIGH;
    }

    private final Long leftID;
    private final Long rightID;
    private final ACCURACY accuracy;

    public Match(Long leftID, Long rightID, ACCURACY accuracy) {
        this.leftID = leftID;
        this.rightID = rightID;
        this.accuracy = accuracy;
    }

    public String toCSVRow(String separator) {
        return leftID + separator + rightID + separator + accuracy;
    }

    public static class MatchBuilder {
        private Long leftID;
        private Long rightID;
        private ACCURACY accuracy;

        public MatchBuilder(){}

        public Match.MatchBuilder leftID(Long leftID) {
            this.leftID = leftID;
            return this;
        }

        public Match.MatchBuilder rightID(Long rightID) {
            this.rightID = rightID;
            return this;
        }

        public Match.MatchBuilder accuracy(ACCURACY accuracy) {
            this.accuracy = accuracy;
            return this;
        }

        public Match build() {
            return new Match(this.leftID, this.rightID, this.accuracy);
        }
    }
}

package com.SincronizacaoReceita.SincronizacaoReceita.exception;

public class ReceitaBadRequestDetails extends ErrorDetails {

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        private long timestamp;
        private String developerMessage;
        private String path;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public ReceitaBadRequestDetails build() {
            ReceitaBadRequestDetails receitaBadRequestDetails = new ReceitaBadRequestDetails();
            receitaBadRequestDetails.setTitle(this.title);
            receitaBadRequestDetails.setDetail(this.detail);
            receitaBadRequestDetails.setTimestamp(this.timestamp);
            receitaBadRequestDetails.setStatus(this.status);
            receitaBadRequestDetails.setDeveloperMessage(this.developerMessage);
            receitaBadRequestDetails.setPath(this.path);
            return receitaBadRequestDetails;
        }
    }
}

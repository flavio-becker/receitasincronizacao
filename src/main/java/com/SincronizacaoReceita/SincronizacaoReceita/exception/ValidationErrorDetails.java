package com.SincronizacaoReceita.SincronizacaoReceita.exception;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrorDetails extends ErrorDetails {

    private Map<String, String> field = new HashMap<>();

    public Map<String, String> getField() {
        return field;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String detail;
        Map<String, String> field = new HashMap<>();
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

        public Builder field(Map<String, String> field) {
            this.field = field;
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

        public ValidationErrorDetails build() {
            ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
            validationErrorDetails.setTitle(this.title);
            validationErrorDetails.setDetail(this.detail);
            validationErrorDetails.setTimestamp(this.timestamp);
            validationErrorDetails.setStatus(this.status);
            validationErrorDetails.setDeveloperMessage(this.developerMessage);
            validationErrorDetails.setPath(this.path);
            validationErrorDetails.field = this.field;

            return validationErrorDetails;
        }
    }
}

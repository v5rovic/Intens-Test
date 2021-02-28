package com.hrmanager.demo.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFound extends RuntimeException{
        private String resourceName;
        private String fieldName;
        private Object fieldValue;

        public ResourceNotFound( String resourceName, String fieldName, Object fieldValue) {
            super(String.format("%s with %s : '%s' not found in DB!", resourceName, fieldName, fieldValue));
            this.resourceName = resourceName;
            this.fieldName = fieldName;
            this.fieldValue = fieldValue;
        }

        public String getResourceName() {
            return resourceName;
        }

        public String getFieldName() {
            return fieldName;
        }

        public Object getFieldValue() {
            return fieldValue;
        }


}

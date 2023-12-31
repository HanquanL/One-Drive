package com.udacity.jwdnd.course1.cloudstorage.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NoteNotFoundException extends RuntimeException implements GraphQLError {

        private Map<String, Object> extensions = new HashMap<>();

        public NoteNotFoundException(String message, Long invalidNoteId) {
            super(message);
            extensions.put("invalidNoteId", invalidNoteId);
        }

        @Override
        public Map<String, Object> getExtensions() {
            return extensions;
        }

        @Override
        public List<SourceLocation> getLocations() {
            return null;
        }

        @Override
        public ErrorType getErrorType() {
            return ErrorType.DataFetchingException;
        }
}

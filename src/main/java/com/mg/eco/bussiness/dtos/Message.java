package com.mg.eco.bussiness.dtos;

public record Message(int code, String message, String messageDesc, Object object) {
    public static MessageBuilder messageBuilder(int code){
        return new MessageBuilder(code);
    }

    public static class MessageBuilder{
        private int code;
        private String message;
        private String description;
        private Object object;

        public MessageBuilder(int code) {
            this.code = code;
        }

        public MessageBuilder setCode(int code) {
            this.code = code;
            return this;
        }

        public MessageBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public MessageBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public MessageBuilder setObject(Object object) {
            this.object = object;
            return this;
        }

        public Message build() {
            return new Message(code, message, description, object);
        }
    }
}

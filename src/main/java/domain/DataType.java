package domain;

public enum DataType {

    String {
        @Override
        protected boolean isValid(Object val) {
            return String.class.equals(val.getClass());  // TODO: replace placeholder code with actual validation as specified
        }
    }, PhoneNumber {
        @Override
        protected boolean isValid(Object val) {
            return false;// TODO: replace placeholder code with actual validation as specified
        }
    }, Date {
        @Override
        protected boolean isValid(Object val) {
            return false; // TODO: replace placeholder code with actual validation as specified
        }
    }, Integer {
        @Override
        protected boolean isValid(Object val) {
            return false; // TODO: replace placeholder code with actual validation as specified
        }
    };

    protected abstract boolean isValid(Object val);
}

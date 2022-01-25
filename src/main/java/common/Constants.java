package common;

public class Constants {
    public enum ExceptionClass{
        MEMBER("Member"), JOIN("Join"), BOARD("Board");

        private String exceptionClass;

        ExceptionClass(String exceptionClass){
            this.exceptionClass = exceptionClass;
        }

        public String getExceptionClass(){
            return this.exceptionClass;
        }

        @Override
        public String toString(){
            return getExceptionClass() + " Exception.";
        }
    }
}

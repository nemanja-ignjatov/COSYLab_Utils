package fog.faca.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.security.KeyPair;
import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class FACAProjectConstants {

    public static final long serialVersionUID = 7526472295622776147L;
    public static final String HEADER_NAME_SET_TOKEN = "Set-Authorization";
    public static final String HEADER_NAME_TOKEN = "Authorization";
    public static final String HEADER_NAME_AUTH_CODE = "AuthCode";
    public static final int USER_PROXY_ID_LENGTH = 64;
    //Cache names
    public static final String ERR_INTERNAL_SRV_MSG = "Oops! Something really went wrong, contact developer!";
    public static final int ALLOWED_PASSWORD_FAILS = 5;
    public static final String ACCESS_POLICY_JSON_FIELD_TYPE = "accessRuleType";

    public static final String USER_PROXY_ID = "userProxyId";
    public static final String BOOLEAN_STRING_VALUE_TRUE = "true";
    public static final String BOOLEAN_STRING_VALUE_FALSE = "false";

    public static final int ERR_RESP_MAP_SIZE = 2;
    public static final String ERR_RESP_MAP_ERR_CODE = "errorCode";
    public static final String ERR_RESP_MAP_ERR_MSG = "errorMessage";

    public enum PAP_REQUEST_TYPE {
        PAP_GET_POLICYSET, PAP_GET_POLICY, PAP_ADD_RULE, PAP_REMOVE_RULE
    }

    public enum PIP_REQUEST_TYPE {
        PIP_CHANGE_ROLE, PIP_UPDATE_ACTIVE_FLAG, PIP_GET_SUBJECT_LIST, PIP_GET_SUBJECT_MNGMT_CONFIG, PIP_ADD_PROFESSION,
        PIP_REMOVE_PROFESSION, PIP_ADD_HANDICAP, PIP_REMOVE_HANDICAP, PIP_GET_ALL_DEVICETYPES, PIP_UPDATE_DEVICE
    }

    public enum FRONTEND_VIEW {
        DEVICE_CONTROL("DevCtrl"),
        DEVICE_CRUD("DevCRUD"),
        GUEST_ACCESS_RULES("GuestAR"),
        ALL_USERS_ACCESS_RULES("AllUsersAR"),
        SUBJECT_MANAGEMENT("SubjectMgmt");

        private final String viewName;

        FRONTEND_VIEW(final String viewName) {
            this.viewName = viewName;
        }

        @Override
        public String toString() {
            return viewName;
        }
    }

    public enum LOCATION_ACTION{
        ACTION_ENTERED("entered"),
        ACTION_LEFT("left"),
        ACTION_REMAINED("remained");

        private final String action;

        LOCATION_ACTION(String action) {
            this.action = action;
        }

        @Override
        public String toString(){
            return action;
        }
    }

    public enum POLICY_PRIORITY {
        PRIORITY_0(0),
        PRIORITY_1(1);

        private final int value;

        POLICY_PRIORITY(final int value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    public static String convertListStringToJSON(List<String> stringList) {
        if (stringList != null) {
            ObjectMapper objMapper = new ObjectMapper();
            try {
                return objMapper.writeValueAsString(stringList);
            } catch (JsonProcessingException e) {
                return null;
            }
        }
        return null;
    }

    public static final String CONTEXT_ATTR_NAME_START = "Context.";

    public enum Role {
        OWNER("Owner"),
        ADMINISTRATOR("Administrator"),
        DEVICE_MANAGER("Device Manager"),
        GUEST_MANAGER("Guest Manager"),
        GUEST("Guest"),
        UNDEFINED("Undefined");

        private final String roleName;

        Role(final String roleName) {
            this.roleName = roleName;
        }

        public String getRoleName() {
            return roleName;
        }

        @Override
        public String toString() {
            return roleName;
        }
    }
}

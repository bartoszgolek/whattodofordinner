package biz.golek.whattodofordinner.business.contract.request_data;

public enum Duration {
    Short,
    Medium,
    Long;

    public static Duration fromInt(Integer value)
    {
        switch (value){
            case 0: return Duration.Short;
            case 1: return Duration.Medium;
            case 2: return Duration.Long;
            default:
                throw new RuntimeException();
        }
    }

    public static Integer toInt(Duration value)
    {
        if (value == Duration.Short)
            return 0;
        if (value == Duration.Medium)
            return 1;
        if (value == Duration.Long)
            return 2;

        throw new RuntimeException();
    }
}

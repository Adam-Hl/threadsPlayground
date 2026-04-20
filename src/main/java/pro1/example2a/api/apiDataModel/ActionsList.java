package pro1.example2a.api.apiDataModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActionsList
{
    @SerializedName("rozvrhovaAkce")
    public List<Action> items;
}

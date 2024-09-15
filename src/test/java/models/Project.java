package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = "id")
public class Project {
    private int id;
    private String name;
    private String announcement;

    @SerializedName(value = "show_announcement") // для работы с гсон
    @JsonProperty("show_announcement") // для работы с джексоном (используется по умолчанию)
    private boolean isShowAnnouncement;

    @SerializedName(value = "suite_mode")
    @JsonProperty("suite_mode")
    private int suiteMode;
}
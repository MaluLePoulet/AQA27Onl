import lombok.Data;

@Data
public class Milestone {
    private String name = "Milestone";
    private String references = "Reference";
    private int parentId = 2;
    private String description = "Description";
    private String startDate = "09/02/2024";
    private String endDate = "09/03/2024";
}
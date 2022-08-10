package api.pojo;

import java.util.List;
import java.util.Map;

public class ItunesPojo {
    private int resultCount;

    public int getResultCount() {
        return resultCount;
    }

    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public List<Map<String, Object>> getResults() {
        return results;
    }

    public void setResults(List<Map<String, Object>> results) {
        this.results = results;
    }

    private List<Map<String,Object>> results;

}

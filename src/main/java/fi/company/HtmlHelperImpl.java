package fi.company;

import org.springframework.stereotype.Service;

@Service
public class HtmlHelperImpl implements HtmlHelper {
    public String createH1(String title) {
        StringBuilder sb = new StringBuilder();

        sb.append("<h1>");
        sb.append(title);
        sb.append("</h1>");

        return sb.toString();
    }
}

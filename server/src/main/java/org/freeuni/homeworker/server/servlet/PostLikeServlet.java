package org.freeuni.homeworker.server.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.freeuni.homeworker.server.database.managers.postLikeManager.PostLikeManager;
import org.freeuni.homeworker.server.model.postLike.PostLikeObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


@WebServlet("/PostLikeServlet")
public class PostLikeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jSonObject = getJSonStringFromRequest(request);
        executeRequest(request, jSonObject);
    }

    /**
     * Executes Given Request
     *
     * @param request
     * @param jSonObject JSon String
     * @throws IOException
     */
    private void executeRequest(HttpServletRequest request, String jSonObject) {
        try {
            PostLikeObject postLikeObject = new ObjectMapper().readValue(jSonObject, PostLikeObject.class);
            PostLikeManager likeModuleManager = (PostLikeManager) request.getServletContext().getAttribute("likeModuleManager");
            if(postLikeObject.isLiked()){
                likeModuleManager.like(postLikeObject);
            } else {
                likeModuleManager.unLike(postLikeObject);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads JSon String From Request
     * @param request Servlet Request
     * @return JSon String
     */
    private String getJSonStringFromRequest(HttpServletRequest request) {
        StringBuffer jSonString = new StringBuffer();
        try {
            BufferedReader reader = request.getReader();
            while (true){
                String line = reader.readLine();
                if(line == null ){ break; }
                jSonString.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSonString.toString();
    }
}

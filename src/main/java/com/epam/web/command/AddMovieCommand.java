package com.epam.web.command;

import com.epam.web.dao.DaoException;
import com.epam.web.service.GenreService;
import com.epam.web.service.MovieService;
import com.epam.web.service.ServiceException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

public class AddMovieCommand implements Command {

    private MovieService movieService;
    private GenreService genreService;

    private final static String ADD_MOVIE_PAGE_COMMAND = "addMoviePage";

    private static final String NAME = "name";
    private static final String PATH_TO_IMAGE = "pathToImage";
    private static final String DESCRIPTION = "description";
    private static final String GENRE_ID = "genre";

    public AddMovieCommand(MovieService movieService, GenreService genreService) {
        this.movieService = movieService;
        this.genreService = genreService;
    }

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws DaoException, ServiceException {

        String movieName = request.getParameter(NAME);
        String pathToImage = request.getParameter(PATH_TO_IMAGE);
        String description = request.getParameter(DESCRIPTION);
        String genreIdAsString = request.getParameter(GENRE_ID);


        try {
            Long genreId = genreService.getGenreIdByName(genreIdAsString);
             movieService.saveMovie(movieName, pathToImage, description, genreId);
        } catch (ServiceException e) {
            request.setAttribute("incorrectGenre", true);
            return CommandResult.forward("/WEB-INF/view/adminAddMovie.jsp");
        }


        return CommandResult.redirect(ADD_MOVIE_PAGE_COMMAND);
    }
}

















//    private static final String CONSTANT_PATH = "/Users/vez/Documents/projects/EpamFinalProject/src/main/webapp/static/img/";
//        try {
//            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
//            List<FileItem> items = servletFileUpload.parseRequest(request);
//
//            for (FileItem fileItem : items) {
//                File file = new File(CONSTANT_PATH + fileItem.getName());
//                fileItem.write(file);
//                String pathToImage = file.getAbsolutePath().substring(63);


//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
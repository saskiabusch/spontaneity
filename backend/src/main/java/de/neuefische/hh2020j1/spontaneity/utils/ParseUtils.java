package de.neuefische.hh2020j1.spontaneity.utils;

import de.neuefische.hh2020j1.spontaneity.dto.SendPostDto;
import de.neuefische.hh2020j1.spontaneity.model.Post;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class ParseUtils {

    public static List<SendPostDto> parseToSendPostDto(List<Post>posts){

       return posts.stream()
                .map(post->new SendPostDto(
                        post.getId(),
                        post.getCreator(),
                        LocalDate.ofInstant(post.getStartPoint(), ZoneId.of("Europe/Berlin")),
                        LocalTime.ofInstant(post.getStartPoint(),ZoneId.of("Europe/Berlin")),
                        LocalTime.ofInstant(post.getEndPoint(),ZoneId.of("Europe/Berlin")),
                        post.getLocation(),
                        post.getStatusLocation(),
                        post.getCategory(),
                        post.getNotes(),
                        post.getTimestamp()))
                        .collect(Collectors.toList());


    }

    public static List<Post> parseToPost(List<SendPostDto>sendPosts){

        Instant instant=Instant.now();

        return sendPosts.stream()
                .map(sendPost->new Post(
                        sendPost.getId(),
                        sendPost.getCreator(),
                        sendPost.getLocalDate().atTime(sendPost.getStartPoint()).atZone(ZoneId.of("Europe/Berlin")).toInstant(),
                        sendPost.getLocalDate().atTime(sendPost.getEndPoint()).atZone(ZoneId.of("Europe/Berlin")).toInstant(),
                        sendPost.getLocation(),
                        sendPost.getStatusLocation(),
                        sendPost.getCategory(),
                        sendPost.getNotes(),
                        sendPost.getTimestamp()))
                        .collect(Collectors.toList());
    }
}


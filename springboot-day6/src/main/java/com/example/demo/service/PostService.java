package com.example.demo.service;

import com.example.demo.dto.PostDTO;
import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PostDTO createPost(PostDTO postDTO) {
        User user = userRepository.findById(postDTO.getUserId()).orElseThrow();
        Post post = modelMapper.map(postDTO, Post.class);
        post.setUser(user);
        return modelMapper.map(postRepository.save(post), PostDTO.class);
    }

    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream()
            .map(post -> modelMapper.map(post, PostDTO.class))
            .collect(Collectors.toList());
    }

    public List<PostDTO> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId).stream()
            .map(post -> modelMapper.map(post, PostDTO.class))
            .collect(Collectors.toList());
    }
}

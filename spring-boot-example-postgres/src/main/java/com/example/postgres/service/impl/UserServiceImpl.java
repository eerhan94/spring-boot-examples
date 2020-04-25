package com.example.postgres.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.postgres.dto.UserDto;
import com.example.postgres.entity.Address;
import com.example.postgres.entity.User;
import com.example.postgres.repository.AddressRepository;
import com.example.postgres.repository.UserRepository;
import com.example.postgres.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User userDb = userRepository.save(user);

        List<Address> list = new ArrayList<>();
        userDto.getAddresses().forEach(item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAdresType(Address.AdresType.OTHER);
            address.setActive(true);
            address.setUser(userDb);
            list.add(address);
        });
        addressRepository.saveAll(list);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> kisiler = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        kisiler.forEach(it -> {
            UserDto userDto =new UserDto();
            userDto.setId(it.getId());
            userDto.setName(it.getName());
            userDto.setSurname(it.getSurname());
            userDto.setAddresses(
                    it.getAddresses() != null ?
                    it.getAddresses().stream().map(Address::getAddress).collect(Collectors.toList())
                            : null);
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}

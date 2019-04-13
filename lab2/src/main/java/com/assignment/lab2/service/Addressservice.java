/*
 * package com.assignment.lab2.service;
 * 
 * import java.util.Optional;
 * 
 * import javax.transaction.Transactional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.assignment.lab2.dao.AddressDao; import
 * com.assignment.lab2.entity.*;
 * 
 * @Service
 * 
 * @Transactional public class Addressservice {
 * 
 * @Autowired AddressDao addDao;
 * 
 * public void DeleteAddress(int Addressid) { this.addDao.deleteById(Addressid);
 * }
 * 
 * public Optional<AddressEntity> GetAddress(int Addressid){ return
 * this.addDao.findById(Addressid); }
 * 
 * public AddressEntity AddAddress(AddressEntity add) { return
 * this.addDao.save(add); }
 * 
 * 
 * 
 * 
 * }
 */
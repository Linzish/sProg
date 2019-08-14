package me.unc.tyg_ms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import me.unc.tyg_ms.dao.*;
import me.unc.tyg_ms.dto.*;
import me.unc.tyg_ms.service.TygmsYhglService;

@Transactional(propagation = Propagation.REQUIRED, 
	isolation = Isolation.DEFAULT, 
	rollbackFor = Exception.class , 
	noRollbackFor = RuntimeException.class)
@Service("tygmsYhglService")
public class TygmsYhglServiceImpl implements TygmsYhglService{
	
	//注入Dao
	@Autowired
	private UserDao userDao;
	@Autowired
	private User_DetailDao user_detailDao;
	@Autowired
	private IdentityDao identityDao;
	@Autowired
	private PowerDao powerDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderDetailDao orderDetailDao;
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private AdminDao adminDao;
	
	/***************** 用户服务接口实现 ******************/
	/**
	 * TygmsYhglService接口login方法实现
	 * @see{ TygmsYhglService }
	 */
	@Transactional(readOnly = true)
	@Override
	public User login(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl login -----> " + username);
		return userDao.findByLoginnameAndPassword(username, password);
	}
	
	/**
	 * TygmsYhglService接口addUser方法实现
	 * @see{ TygmsYhglService }
	 */
	@Override
	public void addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl addUser -----> " + user.toString());
		userDao.saveUser(user);
	}
	
	/**
	 * TygmsYhglService接口modifyUser方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyUser(User user) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyUser -----> " + user.toString());
		userDao.update(user);
	}
	
	/**
	 * TygmsYhglService接口modifyUserState方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyUserState(Integer id, Integer state) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyUserState -----> " + id);
		if(state == 0) {
			userDao.loginStateTo0(id);
		}
		if(state == 1) {
			userDao.loginStateTo1(id);
		}
	}
	
	/**
	 * TygmsYhglService接口removeUserById方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void removeUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl removeUserById -----> " + id);
		userDao.deleteById(id);
	}
	
	/**
	 * TygmsYhglService接口findUserById方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public User findUserById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findUserById -----> " + id);
		return userDao.findById(id);
	}
	
	/**
	 * TygmsYhglService接口findUserByName方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public User findUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findUserByName -----> " + name);
		return userDao.findByName(name);
	}
	
	/**
	 * TygmsYhglService接口findAllUser方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<User> findAllUser() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findAllUser -----> ");
		return userDao.findAllUser();
	}
	
	/**
	 * TygmsYhglService接口userAddDetail方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void userAddDetail(Integer id, Integer user_id) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl userAddDetail -----> ");
		userDao.addUserDetail(id, user_id);
	}
	
	/**
	 * TygmsYhglService接口findUserByIdentity方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<User> findUserByIdentity(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findUserByIdentity -----> " + id);
		return userDao.findUserByIdentity(id);
	}
	
	/**
	 * TygmsYhglService接口userRequestIdentity方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void userRequestIdentity(Integer user_id, Integer identity_id) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl userRequestIdentity -----> user_id = " + user_id + "identity_id = " + identity_id);
		userDao.identityRequest(user_id, identity_id);
	}
	/******************** 用户详细信息服务接口实现 *********************/
	/**
	 * TygmsYhglService接口finduserdetailByUserId方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public User_Detail finduserdetailByUserId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return user_detailDao.findByUserId(id);
	}

	/**
	 * TygmsYhglService接口addUserDetail方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void addUserDetail(User_Detail user_detail) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl addUserDetail -----> " + user_detail.toString());
		user_detailDao.insert(user_detail);
	}
	
	/**
	 * TygmsYhglService接口removeUserDetailById方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void removeUserDetailById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl removeUserDetailById -----> " + id);
		user_detailDao.deleteById(id);
	}
	
	/**
	 * TygmsYhglService接口modifyUserDetail方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyUserDetail(User_Detail user_detail) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyUserDetail -----> " + user_detail.toString());
		user_detailDao.update(user_detail);
	}
	
	/**
	 * TygmsYhglService接口findUserDetailById方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public User_Detail findUserDetailById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findUserDetailById -----> " + id);
		return user_detailDao.findById(id);
	}
	
	/**
	 * TygmsYhglService接口bindingUser方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void bindingUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl bindingUser -----> " + id);
		user_detailDao.bindingUser(id);
	}
	
	/**
	 * TygmsYhglService接口modifyUserDetailState方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyUserDetailState(Integer id, Integer state) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyUserDetailState -----> " + id);
		if(state == 0) {
			user_detailDao.updateStateTo0(id);
		}
		if(state == 1) {
			user_detailDao.updateStateTo1(id);
		}
	}
	/******************** 身份信息服务接口实现 *********************/
	/**
	 * TygmsYhglService接口findIdentityById方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public Identity findIdentityById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findIdentityById -----> " + id);
		return identityDao.findById(id);
	}
	
	/**
	 * TygmsYhglService接口findIdentityByName方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public Identity findIdentityByName(String name) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findIdentityById -----> " + name);
		return identityDao.findByName(name);
	}
	
	/**
	 * TygmsYhglService接口addIdentity方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void addIdentity(Identity identity) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl addIdentity -----> " + identity.toString());
		identityDao.addIdentity(identity);
	}
	
	/**
	 * TygmsYhglService接口removeIdentityById方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void removeIdentityById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl removeIdentityById -----> " + id);
		identityDao.deleteById(id);
	}
	
	/**
	 * TygmsYhglService接口modifyIdentity方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyIdentity(Identity identity) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyIdentity -----> " + identity.toString());
		identityDao.update(identity);
	}
	
	/**
	 * TygmsYhglService接口findAllIdentity方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Identity> findAllIdentity() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findAllIdentity -----> ");
		return identityDao.findAll();
	}
	/******************** 权限信息服务接口实现 ********************/
	/**
	 * TygmsYhglService接口findPowerById方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public Power findPowerById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findPowerById -----> " + id);
		return powerDao.findById(id);
	}
	
	/**
	 * TygmsYhglService接口addPower方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void addPower(Power power) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl addPower -----> " + power.toString());
		powerDao.addPower(power);
	}
	
	/**
	 * TygmsYhglService接口removePowerById方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void removePowerById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl removePowerById -----> " + id);
		powerDao.delete(id);
	}
	
	/**
	 * TygmsYhglService接口modifyPower方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyPower(Power power) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyPower -----> " + power.toString());
		powerDao.update(power);
	}
	
	/**
	 * TygmsYhglService接口findAllPower方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Power> findAllPower() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findAllPower -----> ");
		return powerDao.findAll();
	}
	/*********************** 超级用户 *************************/
	/**
	 * TygmsYhglService接口addIdentityPowerRelation方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void addIdentityPowerRelation(Identity identity, Power power) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl addIdentityPowerRelation -----> ");
		System.out.println(identity.toString());
		System.out.println(power.toString());
		adminDao.addIdentity_Power(identity, power);
	}
	
	/**
	 * TygmsYhglService接口modifyUserIdentity方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyUserIdentity(Integer id, Integer user_id) {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyUserIdentity -----> ");
		adminDao.identityUser(id, user_id);
	}
	
	/**
	 * TygmsYhglService接口deleteRequest方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void removeRequest(Integer user_id) throws Exception{
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl deleteRequest -----> " + user_id);
		adminDao.deleteRequest(user_id);
	}

	/**
	 * TygmsYhglService接口findAllRequest方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Request> findAllRequest() throws Exception{
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findAllRequest -----> ");
		return adminDao.findAllRequest();
	}
	
	/**
	 * TygmsYhglService接口adminLogin方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public Admin adminLogin(String username, String password) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl adminLogin -----> " + username);
		return adminDao.findByUsernameAndPassword(username, password);
	}

	/**
	 * TygmsYhglService接口findRequestState0方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public List<Request> findRequestState0(Integer state) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findRequestState0 -----> ");
		return adminDao.findRequestState0(state);
	}

	/**
	 * TygmsYhglService接口findRequestState1方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public List<Request> findRequestState1(Integer state) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findRequestState1 -----> ");
		return adminDao.findRequestState1(state);
	}

	/**
	 * TygmsYhglService接口modifyRequestStateTo1方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyRequestStateTo1(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyRequestStateTo1 -----> ");
		adminDao.modifyRequestStateTo1(id);
	}

	/********************* 订单信息/订单信息详细服务接口实现 ***********************/
	/**
	 * TygmsYhglService接口findOrderById方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public Order findOrderById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findOrderById -----> " + id);
		return orderDao.findById(id);
	}
	
	/**
	 * TygmsYhglService接口findOrderByUserId方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Order> findOrderByUserId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findOrderByUserId -----> " + id);
		return orderDao.findByUserId(id);
	}
	
	/**
	 * TygmsYhglService接口addOrder方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void addOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl addOrder -----> " + order.toString());
		orderDao.saveOrder(order);
	}
	
	/**
	 * TygmsYhglService接口removeOrderById方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void removeOrderById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl removeOrderById -----> " + id);
		orderDao.delete(id);
	}
	
	/**
	 * TygmsYhglService接口modifyOrder方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyOrder(Order order) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyOrder -----> " + order.toString());
		orderDao.update(order);
	}
	
	/**
	 * TygmsYhglService接口modifyOrderState方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyOrderState(Integer id, Integer state) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyOrderState -----> " + id);
		if(state == 0) {
			orderDao.updateStateTo0(id);
		}
		if(state == 1) {
			orderDao.updateStateTo1(id);
		}
	}
	
	/**
	 * TygmsYhglService接口findAllOrder方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Order> findAllOrder() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyOrder -----> ");
		return orderDao.findAll();
	}
	
	/**
	 * TygmsYhglService接口findOrderDetail方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public OrderDetail findOrderDetail(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findOrderDetail -----> " + id);
		return orderDetailDao.findById(id);
	}
	
	/**
	 * TygmsYhglService接口findOrderDetailByOrderId方法实现（待实现）
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public OrderDetail findOrderDetailByOrderId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findOrderDetailByOrderId -----> " + id);
		return null;
	}
	/*********************  公布信息服务接口实现 *********************/
	/**
	 * TygmsYhglService接口findMessageById方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public Message findMessageById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findMessageById -----> " + id);
		return messageDao.findById(id);
	}
	
	/**
	 * TygmsYhglService接口findMessageByUserId方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Message> findMessageByUserId(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findMessageByUserId -----> " + id);
		return messageDao.findByUserId(id);
	}
	
	/**
	 * TygmsYhglService接口findAllMessage方法实现
	 * @see{TygmsYhglService}
	 */
	@Transactional(readOnly = true)
	@Override
	public List<Message> findAllMessage() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findMessageByUserId -----> ");
		return messageDao.findAll();
	}
	
	/**
	 * TygmsYhglService接口addMessage方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void addMessage(Message message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findMessageByUserId -----> " + message.toString());
		messageDao.insert(message);
	}
	
	/**
	 * TygmsYhglService接口removeMessageById方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void removeMessageById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl removeMessageById -----> " + id);
		messageDao.delete(id);
	}
	
	/**
	 * TygmsYhglService接口modifyMessage方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyMessage(Message message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl removeMessageById -----> " + message.toString());
		messageDao.update(message);
	}
	
	/**
	 * TygmsYhglService接口modifyMessageState方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public void modifyMessageState(Integer id, Integer state) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl modifyMessageState -----> " + id);
		if(state == 0) {
			messageDao.updateStateTo0(id);
		}
		if(state == 1) {
			messageDao.updateStateTo1(id);
		}
	}

	/**
	 * TygmsYhglService接口findMessageWithstate1方法实现
	 * @see{TygmsYhglService}
	 */
	@Override
	public List<Message> findMessageWithstate1() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("TygmsYhglServiceImpl findMessageWithstate1 -----> ");
		return messageDao.findByState1();
	}

}

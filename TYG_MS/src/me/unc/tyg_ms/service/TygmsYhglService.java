package me.unc.tyg_ms.service;

import java.util.List;

import me.unc.tyg_ms.dto.*;

public interface TygmsYhglService {

	/**
	 * 用户登录
	 * @param username 登录名
	 * @param password 密码
	 * @return User对象
	 */
	User login(String username, String password) throws Exception;
	
	/**
	 * 添加用户/注册
	 * @param user
	 */
	void addUser(User user) throws Exception;
	
	/**
	 * 修改用户
	 * @param user
	 */
	void modifyUser(User user) throws Exception;
	
	/**
	 * 修改用户状态(on/off)
	 */
	void modifyUserState(Integer id, Integer state) throws Exception;
	
	/**
	 * 根据id删除用户
	 * @param id
	 */
	void removeUserById(Integer id) throws Exception;
	 /**
	  * 根据id查找用户
	  * @param id 
	  * @return User对象
	  */
	User findUserById(Integer id) throws Exception;
	
	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return
	 */
	User findUserByName(String name) throws Exception;
	
	/**
	 * 添加用户详细信息
	 * @param id
	 * @throws Exception
	 */
	void userAddDetail(Integer id, Integer user_id) throws Exception;
	
	/**
	 * 查找所有用户
	 * @return User对象List
	 */
	List<User> findAllUser() throws Exception;
	
	/**
	 * 添加用户详细信息
	 * @param user_detail
	 */
	void addUserDetail(User_Detail user_detail) throws Exception;
	
	/**
	 * 根据id删除用户详细信息
	 * @param id
	 */
	void removeUserDetailById(Integer id) throws Exception;
	
	/**
	 * 修改用户详细信息
	 * @param user_detail
	 */
	void modifyUserDetail(User_Detail user_detail) throws Exception;
	
	/**
	 * 根据id查找用户详细信息
	 * @param id
	 * @return User_Detail对象
	 */
	User_Detail findUserDetailById(Integer id) throws Exception;
	
	/**
	 * 修改用户详细信息状态
	 */
	void modifyUserDetailState(Integer id, Integer state) throws Exception;
	
	/**
	 * 用户详细信息绑定用户
	 * @param id
	 */
	void bindingUser(Integer id) throws Exception;
	
	 /**
	  * 根据身份id查找用户
	  * @param id
	  * @return User对象List
	  */
	List<User> findUserByIdentity(Integer id) throws Exception;
	
	/**
	 * 根据id查找身份信息
	 * @param id
	 * @return Identity对象
	 */
	Identity findIdentityById(Integer id) throws Exception;
	
	/**
	 * 根据名字查找身份信息
	 * @param id
	 * @return Identity对象
	 */
	Identity findIdentityByName(String name) throws Exception;
	
	/**
	 * 添加身份信息
	 * @param identity
	 */
	void addIdentity(Identity identity) throws Exception;
	/**
	 * 根据id删除身份信息
	 * @param id
	 */
	void removeIdentityById(Integer id) throws Exception;
	
	/**
	 * 修改身份信息
	 * @param identity
	 */
	void modifyIdentity(Identity identity) throws Exception;
	
	/**
	 * 根据id查权限
	 * @param id
	 * @return Power对象
	 */
	Power findPowerById(Integer id) throws Exception;
	
	 /**
	  * 添加权限信息
	  * @param power
	  */
	void addPower(Power power) throws Exception;
	
	/**
	 * 根据id删除权限
	 * @param id
	 */
	void removePowerById(Integer id) throws Exception;
	
	/**
	 * 修改权限信息
	 * @param power
	 */
	void modifyPower(Power power) throws Exception;
	
	/**
	 * 查询所有身份信息
	 * @return Identity对象List
	 */
	List<Identity> findAllIdentity() throws Exception;
	
	/**
	 * 查询所有权限信息
	 * @return Power对象List
	 */
	List<Power> findAllPower() throws Exception;
	
	/**
	 * 添加身份-权限关系（管理员）
	 * @param identity
	 * @param power
	 */
	void addIdentityPowerRelation(Identity identity, Power power) throws Exception;
	
	/**
	 * 根据id查找订单
	 * @param id
	 * @return Order对象
	 */
	Order findOrderById(Integer id) throws Exception;
	
	/**
	 * 根据用户id查找订单
	 * @param id
	 * @return Order对象
	 */
	List<Order> findOrderByUserId(Integer id) throws Exception;
	
	/**
	  * 添加订单
	  * @param order
	  */
	void addOrder(Order order) throws Exception;
	
	/**
	  * 根据id删除订单
	  * @param id
	  */
	void removeOrderById(Integer id) throws Exception;
	
	/**
	 * 修改订单
	 * @param order
	 */
	void modifyOrder(Order order) throws Exception;
	
	/**
	 * 修改订单状态
	 * @param order
	 */
	void modifyOrderState(Integer id, Integer state) throws Exception;
	
	/**
	 * 查询全部订单
	 * @return Order对象List
	 */
	List<Order> findAllOrder() throws Exception;
	
	/**
	 * 根据id查找订单详细
	 * @param id
	 * @return OrderDetail对象
	 */
	OrderDetail findOrderDetail(Integer id) throws Exception;
	
	/**
	 * 根据订单id查找订单详细信息
	 * @param id
	 * @return OrderDetail对象
	 */
	OrderDetail findOrderDetailByOrderId(Integer id) throws Exception;
	
	/**
	 * 根据id查找公布信息
	 * @param id
	 * @return Message对象
	 */
	Message findMessageById(Integer id) throws Exception;
	
	/**
	 * 根据用户id查找信息公布
	 * @param id
	 * @return Message对象
	 */
	List<Message> findMessageByUserId(Integer id) throws Exception;
	 
	/**
	  * 查询全部信息公布
	  * @return Message对象List
	  */
	List<Message> findAllMessage() throws Exception;
	
	/**
	  * 查询可公布的信息公布
	  * @return Message对象List
	  */
	List<Message> findMessageWithstate1() throws Exception;
	
	/**
	 * 添加信息公布
	 * @param message
	 */
	void addMessage(Message message) throws Exception;
	
	/**
	 * 根据id删除信息公布
	 * @param id
	 */
	void removeMessageById(Integer id) throws Exception;
	
	/**
	 * 修改信息公布
	 * @param message
	 */
	void modifyMessage(Message message) throws Exception;
	
	/**
	 * 修改信息公布状态
	 * @param message
	 */
	void modifyMessageState(Integer id, Integer state) throws Exception;
	
	/**
	 * 修改用户身份
	 * @param id
	 */
	void modifyUserIdentity(Integer id, Integer user_id) throws Exception;
	
	/**
	 * 用户请求身份认证
	 * @param user_id 用户id
	 * @param identity_id 身份id
	 */
	void userRequestIdentity(Integer user_id, Integer identity_id) throws Exception;
	
	/**
	 * 根据用户id删除请求
	 * @param user_id
	 */
	void removeRequest(Integer user_id) throws Exception;
	
	/**
	 * 查询所有请求
	 * @return Request对象List
	 */
	List<Request> findAllRequest() throws Exception;
	
	/**
	 * 超级用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	Admin adminLogin(String username, String password) throws Exception;

	/**
	 * 查询状态为1的请求
	 * @return Request对象List
	 * @throws Exception
	 */
	List<Request> findRequestState0(Integer state) throws Exception;
	
	/**
	 * 查询状态为0的请求
	 * @return Request对象List
	 * @throws Exception
	 */
	List<Request> findRequestState1(Integer state) throws Exception;
	
	/**
	 * 更改请求状态为1
	 * @throws Exception
	 */
	void modifyRequestStateTo1(Integer id) throws Exception;
	
	/**
	 * 根据用户id查找用户详细信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User_Detail finduserdetailByUserId(Integer id) throws Exception;
	
}

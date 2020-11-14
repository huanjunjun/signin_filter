package model;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import domain.user;
import utils.c3p0utils;

public class usermodel {
	public user login(user user1) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(c3p0utils.getDataSource());
		user existuser = queryRunner.query("select * from user1 where username= ? and password= ?",
				new BeanHandler<user>(user.class), user1.getUsername(), user1.getPassword());

		return existuser;

	}
}

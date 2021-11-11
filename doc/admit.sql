DROP DATABASE admit;
CREATE DATABASE admit;
USE admit;
CREATE TABLE ranks(
                      rank VARCHAR(15) NOT NULL PRIMARY KEY ,
                      ranknumber INT NOT NULL
);
CREATE TABLE admit(
                      admitID VARCHAR(5) NOT NULL primary key ,
                      phone VARCHAR(12) NOT NULL ,
                      Mail VARCHAR(20) NOT NULL,
                      name VARCHAR(10) NOT NULL,
                      password VARCHAR(20) NOT NULL,
                      sex VARCHAR(2) NOT NULL,
                      rank VARCHAR(10) NOT NULL ,
                      state VARCHAR(10) NOT NULL,
                      starttime DATETIME NOT NULL ,
                      endtime DATETIME,
                      FOREIGN KEY(rank) REFERENCES ranks(rank)
);
CREATE TABLE information(
    sendID VARCHAR(5),
    accentID VARCHAR (5),
    cue VARCHAR(100),
    state INT NOT NULL,
    FOREIGN KEY (sendID) REFERENCES admit(admitID),
    FOREIGN KEY (accentID) REFERENCES admit(admitID)
);
CREATE TABLE qi(
    admitID VARCHAR(5) NOT NULL,
    ly VARCHAR(20)  NOT NULL,
    starttime DATETIME NOT NULL,
    endtime DATETIME NOT NULL,
    spadmitID VARCHAR(5),
    FOREIGN KEY (admitID) REFERENCES admit(admitID),
    FOREIGN KEY (spadmitID) REFERENCES admit(admitID)
);
insert into ranks(rank,ranknumber) values('超级管理员','0');
insert into admit(admitID,password,Mail,name,phone,sex,rank,state,starttime) values('78261' ,'123456' ,'528409336@qq.com' ,'杨鹏飞' ,'18543484146' ,'男' ,'超级管理员' ,'申请就职' ,'2021-11-11' );;
insert into admit(admitID,password,Mail,name,phone,sex,rank,state,starttime) values('78262' ,'123456' ,'528409336@qq.com' ,'杨鹏飞' ,'18543484146' ,'男' ,'超级管理员' ,'申请就职' ,'2021-11-11' );
insert into admit(admitID,password,Mail,name,phone,sex,rank,state,starttime) values('78263' ,'123456' ,'528409336@qq.com' ,'杨鹏飞' ,'18543484146' ,'男' ,'超级管理员' ,'申请就职' ,'2021-11-11' );
insert into admit(admitID,password,Mail,name,phone,sex,rank,state,starttime) values('78264' ,'123456' ,'528409336@qq.com' ,'杨鹏飞' ,'18543484146' ,'男' ,'超级管理员' ,'申请就职' ,'2021-11-11' );
insert into admit(admitID,password,Mail,name,phone,sex,rank,state,starttime) values('78265' ,'123456' ,'528409336@qq.com' ,'杨鹏飞' ,'18543484146' ,'男' ,'超级管理员' ,'申请就职' ,'2021-11-11' );
insert into admit(admitID,password,Mail,name,phone,sex,rank,state,starttime) values('78266' ,'123456' ,'528409336@qq.com' ,'杨鹏飞' ,'18543484146' ,'男' ,'超级管理员' ,'申请就职' ,'2021-11-11' );
insert into admit(admitID,password,Mail,name,phone,sex,rank,state,starttime) values('78267' ,'123456' ,'528409336@qq.com' ,'杨鹏飞' ,'18543484146' ,'男' ,'超级管理员' ,'申请就职' ,'2021-11-11' );
insert into admit(admitID,password,Mail,name,phone,sex,rank,state,starttime) values('78268' ,'123456' ,'528409336@qq.com' ,'杨鹏飞' ,'18543484146' ,'男' ,'超级管理员' ,'申请就职' ,'2021-11-11' );
insert into admit(admitID,password,Mail,name,phone,sex,rank,state,starttime) values('78269' ,'123456' ,'528409336@qq.com' ,'杨鹏飞' ,'18543484146' ,'男' ,'超级管理员' ,'申请就职' ,'2021-11-11' );

insert into information(sendID, accentID, cue, state) VALUES('78262','78269','fndfsndsfnjfdsfksdfkkkkkkkkkkkkkkkkkkk','1');
insert into information(sendID, accentID, cue, state) VALUES('78262','78269','fndfsndsfnjfdsfksdfkkkkkkkkkkkkkkkkkkk','1');
insert into information(sendID, accentID, cue, state) VALUES('78262','78269','fndfsndsfnjfdsfksdfkkkkkkkkkkkkkkkkkkk','1');
insert into information(sendID, accentID, cue, state) VALUES('78262','78269','fndfsndsfnjfdsfksdfkkkkkkkkkkkkkkkkkkk','1');
insert into information(sendID, accentID, cue, state) VALUES('78262','78269','fndfsndsfnjfdsfksdfkkkkkkkkkkkkkkkkkkk','1');
insert into information(sendID, accentID, cue, state) VALUES('78262','78269','fndfsndsfnjfdsfksdfkkkkkkkkkkkkkkkkkkk','1');
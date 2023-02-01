package com.accday17.joins.v1;

import java.util.List;


public interface joinservices {

	List<custorderdto> getLeftJoin();

	List<custorderdto> getRightJoin();

	List<custorderdto> getInnerJoin();

	List<custorderdto> getCrossJoin();
}

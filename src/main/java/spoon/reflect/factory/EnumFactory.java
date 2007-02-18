/* 
 * Spoon - http://spoon.gforge.inria.fr/
 * Copyright (C) 2006 INRIA Futurs <renaud.pawlak@inria.fr>
 * 
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify 
 * and/or redistribute the software under the terms of the CeCILL-C license as 
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info. 
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *  
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */

package spoon.reflect.factory;

import spoon.reflect.Factory;
import spoon.reflect.declaration.CtEnum;
import spoon.reflect.declaration.CtPackage;

/**
 * The {@link CtEnum} sub-factory.
 */
public class EnumFactory extends TypeFactory {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new enum sub-factory.
	 * 
	 * @param factory
	 *            the parent factory
	 */
	public EnumFactory(Factory factory) {
		super(factory);
	}

	/**
	 * Creates a new enumeration type
	 * 
	 * @param owner
	 *            package
	 * @param simpleName
	 *            the simple name
	 */
	public CtEnum create(CtPackage owner, String simpleName) {
		CtEnum e = factory.Core().createEnum();
		e.setSimpleName(simpleName);
		owner.getTypes().add(e);
		e.setParent(owner);
		return e;
	}

	/**
	 * Creates an enum from its qualified name.
	 */
	public CtEnum create(String qualifiedName) {
		return create(factory.Package().getOrCreate(
				getPackageName(qualifiedName)), getSimpleName(qualifiedName));
	}

	/**
	 * Gets an already created enumeration from its qualified name.
	 * 
	 * @return the enumeration or null if does not exist
	 */
	@SuppressWarnings("unchecked")
	public CtEnum get(String qualifiedName) {
		try {
			return (CtEnum) super.get(qualifiedName);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Gets a class from its runtime Java class.
	 * 
	 * @param <T>
	 *            type of created class
	 * @param cl
	 *            java class
	 */
	public <T extends Enum> CtEnum<T> get(Class<T> cl) {
		try {
			return (CtEnum<T>) super.get(cl);
		} catch (Exception e) {
			return null;
		}
	}

}
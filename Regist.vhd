LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY Regist IS
GENERIC(n : IN POSITIVE := 16);
PORT(
	I: IN std_logic_vector(0 TO (n-1));
	w, Clock: IN std_logic;
	O: OUT std_logic_vector(0 TO (n-1))
);
END Regist;

Architecture Behavior of Regist IS
BEGIN
	PROCESS(Clock)
	BEGIN
		if w = '1' then
			O <= I;
		end if;
	END PROCESS;
End Behavior;
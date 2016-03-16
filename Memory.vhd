LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY Memory IS
PORT(
	Done, Reset: IN std_logic;
	result : OUT std_logic_vector(0 TO 15);
	instructionStates: OUT integer
);
END Memory;
	
ARCHITECTURE Behavior OF Memory IS
TYPE memory_type IS ARRAY(0 to 4) OF std_logic_vector(0 to 15);

signal mem : memory_type;
signal i : integer;

BEGIN

	mem(0) <= "0010000000000000";--mvi R0
	mem(1) <= "0000000000000001";--1 => R0
	mem(2) <= "0000000010000000";--mv R0 => R1
	mem(3) <= "0100000010000000";--add R0 + R1 => R0
	mem(4) <= "0000000010000000";--mv R0 => R1
	--i <= 0;
	
	nextMem: PROCESS(Done, Reset)
	BEGIN
		if reset = '0'  then
			if(Done'event and Done = '1') then
				result <= mem(i);
				i <= i + 1;
			end if;
		else
			i <= 0;
		end if;
	END PROCESS;
	
	instructionStates <= i;
END Behavior;
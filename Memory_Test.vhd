LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY Memory_Test IS
PORT(
	Done, Reset: IN std_logic;
	result : OUT std_logic_vector(0 TO 15);
	instructionStates: OUT integer
);
END Memory_Test;
	
ARCHITECTURE Behavior OF Memory_Test IS
TYPE memory_type IS ARRAY(0 to 10) OF std_logic_vector(0 to 15);

signal mem : memory_type;
signal i : integer;

BEGIN

	--Test Addition
		--mem(0) <= "0010000000000000";--mvi R0
		--mem(1) <= "0000000000000001";--1 => R0
		--mem(2) <= "0000000010000000";--mv R0 => R1
		--mem(3) <= "0100000010000000";--add R0 + R1 => R0 = 10
		
		--mem(0) <= "0010000000000000";--mvi R0
		--mem(1) <= "0000000000000011";--11 => R0
		--mem(2) <= "0010010000000000";--mvi R1
		--mem(3) <= "0000000000000001";--1 => R1
		--mem(4) <= "0100000010000000";--sub R0 + R1 => R0 = 100
	
	--Test Soustraction
		--mem(4) <= "0010000000000000";--mvi R0
		--mem(5) <= "0000000000000001";--1 => R0
		--mem(6) <= "0010010000000000";--mvi R1
		--mem(7) <= "0000000000000001";--1 => R1
		--mem(8) <= "0110000010000000";--sub R0 - R1 => R0 = 0
		
		--mem(0) <= "0010000000000000";--mvi R0
		--mem(1) <= "0000000000000011";--11 => R0
		--mem(2) <= "0010010000000000";--mvi R1
		--mem(3) <= "0000000000000001";--1 => R1
		--mem(4) <= "0110000010000000";--sub R0 - R1 => R0 = 10
		
		--mem(12) <= "0010000000000000";--mvi R0
		--mem(13) <= "0000000000010001";--11 => R0
		--mem(14) <= "0010010000000000";--mvi R1
		--mem(15) <= "0000000000001101";--1 => R1
		--mem(16) <= "0110000010000000";--sub R0 - R1 => R0
		--mem(17) <= "0000000010000000";--mv R0 => R1
		
	--Test complet
		--mem(0) <= "0010000000000000";--mvi R0
		--mem(1) <= "0000000000000001";--1 => R0
		--mem(2) <= "0010010000000000";--mvi R1
		--mem(3) <= "0000000000000011";--11 => R1
		--mem(4) <= "0100000010000000";--add R0 + R1 => R0 = 100
		
		--mem(5) <= "0010010000000000";--mvi R1
		--mem(6) <= "0000000000000100";--100 => R1
		--mem(7) <= "0010100000000000";--mvi R2
		--mem(8) <= "0000000000000101";--101 => R2
		--mem(9) <= "0100010100000000";--add R1 + R2 => R1 = 1001
		
		--mem(10) <= "0110010000000000";--sub R1 - R0 => R1 = 101
		
		mem(0) <= "0010000000000000";--mvi R0
		mem(1) <= "0000000001101011";--1101011 => R0 = 6B
		mem(2) <= "0010010000000000";--mvi R1
		mem(3) <= "0000000000101101";--101101 => R1 = 2D
		mem(4) <= "0000000100000000";--mv R0 => R2
		
		mem(5) <= "1000100010000000";--R2 & R1 => R2 = 0101001 = 29
		mem(6) <= "0000000100000000";--mv R0 => R2
		
		mem(7) <= "1010100010000000";--R2 | R1 => R2 = 1101111 = 6F
		
		mem(8) <= "1100010000000000";-- not R1 => R1 = 1111111111010010 = FFD2
																											
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
	
	instructionStates <= i-1;
END Behavior;
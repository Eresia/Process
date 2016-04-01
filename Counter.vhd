LIBRARY ieee;
USE ieee.std_logic_1164.all;
use ieee.numeric_std.all;

Entity Counter IS
PORT
	(
		Clock, Reset : IN std_logic;
		instructionState : OUT integer;
		addr : OUT std_logic_vector(0 TO 4)
	);
END Counter;

Architecture Behavior of Counter IS
	signal address : std_logic_vector(0 TO 4);
	signal i : integer;
Begin 
	Process(Clock, Reset)
	BEGIN
		if Reset = '0' then
			if (Clock'event and Clock = '1') then
				address <= std_logic_vector(unsigned(address) + 1);
				i <= i + 1;
			end if;
		else 
			address <= "00000";
			i <= 0;
		end if;
	END Process;
	
	instructionState <= i;
	addr <= address;
	
END Behavior;
LIBRARY ieee;
USE ieee.std_logic_1164.all;
use ieee.numeric_std.all;

Entity Counter IS
PORT
	(
		Clock, Reset : IN std_logic;
		newInstruction : IN std_logic_vector(0 TO 4);
		hasNewInstruction : IN std_logic;
		instructionState : OUT integer;
		addr : OUT std_logic_vector(0 TO 4)
	);
END Counter;

Architecture Behavior of Counter IS
	signal address : std_logic_vector(0 TO 4);
Begin 
	Process(Clock, Reset)
	BEGIN
		if Reset = '0' then
			if (Clock'event and Clock = '1') then
				if hasNewInstruction = '1' then
					address <= newInstruction;
				else
					address <= std_logic_vector(unsigned(address) + 1);
				end if;
			end if;
		else 
			address <= "00000";
		end if;
	END Process;
	
	instructionState <= to_integer(unsigned(address)) -1;
	addr <= address;
	
END Behavior;